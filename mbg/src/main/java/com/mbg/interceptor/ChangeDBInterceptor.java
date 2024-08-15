package com.mbg.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;

@Component
@Intercepts({@Signature(
        type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class, Integer.class}
)})
public class ChangeDBInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation inv) throws Throwable {
        System.out.print("coming in intercept...........");
        StatementHandler target = (StatementHandler)inv.getTarget();
        BoundSql boundSql = target.getBoundSql();

        Connection connection = (Connection)inv.getArgs()[0];
        connection.setCatalog("qfconfigcenter_v20_dev");
        String sql = boundSql.getSql();
        System.out.print(sql);
        return inv.proceed();
    }


    private void updateToNullForSpecialValue(BoundSql boundSql, Object parameterObject, Configuration configuration) {
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (parameterMappings != null) {
            for(int i = 0; i < parameterMappings.size(); ++i) {
                ParameterMapping parameterMapping = (ParameterMapping)parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    String propertyName = parameterMapping.getProperty();
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if (boundSql.hasAdditionalParameter(propertyName)) {
                        boundSql.getAdditionalParameter(propertyName);
                    } else {
                        Object value;
                        if (parameterObject == null) {
                            value = null;
                        } else if (!configuration.getTypeHandlerRegistry().hasTypeHandler(parameterObject.getClass())) {
                            MetaObject metaObject = configuration.newMetaObject(parameterObject);
                            value = metaObject.getValue(propertyName);
//                            if (UpdateNullHelper.isUpdateNullByTypeHandler(typeHandler, value, parameterMapping.getJdbcType())) {
//                                this.logger.info("parameterObject==" + parameterObject + ",value==" + value + ",need upate null");
//                                metaObject.setValue(propertyName, (Object)null);
//                            }
                        }
                    }
                }
            }
        }

    }
}
