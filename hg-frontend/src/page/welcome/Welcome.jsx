import React from 'react';
import { isAuthenticated } from '../../auth/LoginUtil';
import MenuListComposition from '../../components/menu/MenuListComposition';
import './welcome.css';

export default function Welcome({ setloggedIn }) {
  const isAuth = isAuthenticated();

  if (isAuth) {
    setloggedIn();
  }

  return (
    <div className="homePage">
      {/* <h1 className="title" style={{ color: 'white' }}>
        Welcome
      </h1> */}
      <div>
        <title>Welcome Page</title>
        <link rel="stylesheet" href="style.css" />
        {/*<title> Responsive Footer | CodingLab</title>-*/}
        <link rel="stylesheet" href="style.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
        />
        <div className="main">
          <div className="main___home">
            <div className="main__stuff">
              <h1>Welcome to HuskyGroups!</h1>
              <p>
                HuskyGroups is a platform where students can connect and find
                resources for classes or clubs. If there's a group you don't see
                you may search for it above or create it if it doesn't exist
                yet!
              </p>
            </div>
          </div>
        </div>
        <footer
          style={{
            maxWidth: 'calc(100vw - 350px)',
            marginLeft: '350px',
            color: 'rgba(255, 206, 0, 255)',
          }}
        >
          <div className="content">
            <div className="left box">
              <div className="upper">
                <div className="topic">About us</div>
                <p>
                  HuskyGroups is a platform where you can find resources for
                  classes, clubs or even other groups at Michigan Tech. You can
                  find new groups to join or even create your own.
                </p>
              </div>
              <div className="lower">
                <div className="topic">Suggestions? Contact -</div>
                <div className="email">
                  <a href="#">
                    <i className="fas fa-envelope" />
                    HuskyGroups@gmail.com
                  </a>
                </div>
              </div>
            </div>
            <div className="middle box">
              <div className="topic">Other MTU Services</div>
              <div>
                <a href="https://sso.mtu.edu/cas/login?service=https%3A%2F%2Fmymichigantech.mtu.edu%2Fc%2Fportal%2Flogin">
                  My MichiganTech
                </a>
              </div>
              <div>
                <a href="https://sso.mtu.edu/cas/login?service=https%3A%2F%2Fwww.banweb.mtu.edu%3A443%2Fssomanager%2Fc%2FSSB">
                  Banweb
                </a>
              </div>
              <div>
                <a href="https://sso.mtu.edu/cas/login?service=https%3A%2F%2Fmtu.instructure.com%2Flogin%2Fcas%2F759">
                  Canvas
                </a>
              </div>
            </div>
            <div className="right box">
              <div className="topic">Social media</div>
              <form action="#">
                <div className="media-icons">
                  <a href="#">
                    <i className="fab fa-facebook-f" />
                  </a>
                  <a href="#">
                    <i className="fab fa-instagram" />
                  </a>
                  <a href="#">
                    <i className="fab fa-twitter" />
                  </a>
                  <a href="#">
                    <i className="fab fa-youtube" />
                  </a>
                  <a href="#">
                    <i className="fab fa-linkedin-in" />
                  </a>
                </div>
              </form>
            </div>
          </div>
          <div className="bottom">
            <p>
              Copyright © 2021 <a href="#">HuskyGroups</a> All rights reserved
            </p>
          </div>
        </footer>
      </div>
    </div>
  );
}
