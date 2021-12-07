import React from 'react';
import { GoogleLogin } from 'react-google-login';

const clientId =
  '683332058096-q3c8fbajaki5fdiepjn88k6rl3v4011t.apps.googleusercontent.com';

export default function Login() {
  const onSucess = (res) => {
    console.log('[Login Sucess] currentUser:', res.profileObj);
  };

  const onFailure = (res) => {
    console.log('[Login failed] currentUser:', res);
  };
  return (
    <div>
      <GoogleLogin
        clientId={clientId}
        buttonId="Login"
        onSuccess={onSucess}
        onFailure={onFailure}
        cookiePolicy={'single_host_origin'}
        style={{ marginTop: '100px' }}
        isSignedIn={true}
      />
    </div>
  );
}
