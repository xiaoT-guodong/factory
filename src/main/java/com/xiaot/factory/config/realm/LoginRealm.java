package com.xiaot.factory.config.realm;

import com.xiaot.factory.entity.vo.OperatorVo;
import com.xiaot.factory.service.OperatorService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private OperatorService operatorService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        char[] password = token.getPassword();
        OperatorVo operator = operatorService.findOperator(token.getUsername(), new String(password));
        if(operator != null) {
            return new SimpleAuthenticationInfo(operator, password, getName());
        }
        return null;
    }

}
