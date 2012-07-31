package org.grails.cxf.wssecurity

import org.apache.ws.security.WSPasswordCallback
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.core.userdetails.UserDetails

import javax.security.auth.callback.Callback
import javax.security.auth.callback.CallbackHandler

/**
 * Created with IntelliJ IDEA.
 * User: bendoerr
 * Date: 7/30/12
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */
class SpringDigestPasswordValidationCallbackHandler implements CallbackHandler {

    DaoAuthenticationProvider daoAuthenticationProvider

    void handle(final Callback[] callbacks) {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0]
        UserDetails user = loadUserDetails(pc.identifier)
//        if(user != null) {
//            daoAuthenticationProvider.
//        }
    }

    UserDetails loadUserDetails(String username) {
        UserDetails user
        try {
            user = userDetailsService.loadUserByUsername(username)
        } catch (UsernameNotFoundException) {
            // Sadness
        }
        return user
    }
}
