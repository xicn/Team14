import React from 'react';
import './topbar.css';
import { NotificationsNone, Settings } from '@material-ui/icons';
import { img_link } from '../../img/images';
import { Link } from 'react-router-dom';

export default function Topbar() {
  return (
    <div className="topbar">
      <div className="topbarWrapper">
        <div className="topLeft">
          <Link to="/" className="link">
            <span className="logo">Husky Group</span>
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
            <Settings />
          </div>
          <img src={img_link} alt="" className="topAvatar" />
        </div>
      </div>
    </div>
  );
}
