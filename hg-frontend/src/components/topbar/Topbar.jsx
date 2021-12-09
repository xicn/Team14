import React from 'react';
import './topbar.css';
import { NotificationsNone, Settings } from '@material-ui/icons';
import { Link } from 'react-router-dom';
import MenuListComposition from '../menu/MenuListComposition';
import { getCurrentUser } from '../../auth/LoginUtil';

export default function Topbar({
  logOut,
  imgLink = 'https://images.unsplash.com/photo-1590272456521-1bbe160a18ce?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTl8fHxlbnwwfHx8fA%3D%3D&w=1000&q=80',
  loggedIn,
}) {
  // Black bacjground avatar
  const defaultAvatar =
    'https://images.unsplash.com/photo-1590272456521-1bbe160a18ce?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTl8fHxlbnwwfHx8fA%3D%3D&w=1000&q=80';

  return (
    <div className="topbar">
      <div className="topbarWrapper">
        <div className="topLeft">
          <Link to="/" className="link">
            <span className="logo">Husky Groups</span>
          </Link>
        </div>
        <div className="topRight">
          <div className="topbarIconContainer">
            <NotificationsNone />
            <span className="topIconBadge">2</span>
          </div>
          {/* <div className="topbarIconContainer">
            <Language />
            <span className="topIconBadge">2</span>
          </div> */}
          <div className="topbarIconContainer">
            {/* <Settings /> */}
            <MenuListComposition logOut={logOut} />
          </div>
          <Link to="/profile" className="link" onClick>
            <img
              src={loggedIn ? getCurrentUser().img : defaultAvatar}
              alt=""
              className="topAvatar"
            />
          </Link>
        </div>
      </div>
    </div>
  );
}
