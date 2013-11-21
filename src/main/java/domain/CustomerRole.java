package domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Alexey
 */
public enum CustomerRole implements GrantedAuthority {

    ROLE_ADMIN,
    ROLE_USER;

    @Override
    public String getAuthority() {
        return this.toString();
    }
}