import React, { useEffect } from 'react';
import { isAuthenticated } from '../../auth/LoginUtil';
import SignIn from './SignIn';

function Login({ setloggedIn }) {
  const isAuth = isAuthenticated();

  useEffect(() => {
    // Prevent refresh to change logged in state to false
    if (isAuth) {
      setloggedIn();
    }
  }, []);

  return (
    <>
      {isAuth ? (
        <div className="homePage">
          <h1 className="title" style={{ color: 'white' }}>
            You're logged in 😉.
          </h1>
        </div>
      ) : (
        /* <>
          <p>You're in the Home page. Login to visit protected pages.</p>
          <button className="button" onClick={handleLogin}>
            Login as User
          </button>
        </> */

        <SignIn setloggedIn={setloggedIn} />
      )}
    </>
  );
}

export default Login;
