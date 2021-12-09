import { useEffect } from 'react';
import { Navigate } from 'react-router-dom';
import AccessDenied from './AccessDenied';
import { ROLE } from './LoginUtil';
import { getCurrentUser, isAuthenticated } from './LoginUtil';

interface Props {
  component: React.ComponentType;
  path?: string;
  roles: Array<ROLE>;
  loggedIn: any;
  isLoggedIn: any;
}

export const PrivateRoute: React.FC<Props> = ({
  component: RouteComponent,
  roles,
  loggedIn,
  isLoggedIn,
}) => {
  const user = getCurrentUser();
  const isAuth = isAuthenticated();
  const userHasRequiredRole = user && roles.includes(user.role) ? true : false;

  useEffect(() => {
    // Prevent refresh to change logged in state to false
    if (isAuth && !isLoggedIn) {
      loggedIn();
    }
  }, []);

  if (isAuth && userHasRequiredRole) {
    return <RouteComponent />;
  }

  if (isAuth && !userHasRequiredRole) {
    return <AccessDenied />;
  }

  // Not authenticated
  return <Navigate to="/login" />;
};
