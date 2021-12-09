import React from 'react';
import { isAuthenticated } from '../../auth/LoginUtil';
import MenuListComposition from '../../components/menu/MenuListComposition';

export default function Welcome({ setloggedIn }) {
  const isAuth = isAuthenticated();

  if (isAuth) {
    setloggedIn();
  }

  return (
    <div className="homePage">
      <h1 className="title" style={{ color: 'white' }}>
        Welcome
      </h1>
    </div>
  );
}
