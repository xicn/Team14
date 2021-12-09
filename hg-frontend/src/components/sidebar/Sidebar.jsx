import React, { useEffect, useState } from 'react';
import './sidebar.css';
import {
  Forum,
  Home,
  Assignment,
  PeopleAlt,
  Person,
  Search,
  PersonAdd,
  CheckBox,
} from '@material-ui/icons';
import Items from './Items';
import { Link } from 'react-router-dom';

export default function Sidebar({ loggedIn }) {
  if (loggedIn) {
    return (
      <div className="sidebar">
        <div className="sidebarWrapper">
          <div className="sidebarMenu">
            <h3 className="sidebarTitle">Dashboard</h3>
            <ul className="sidebarList">
              <Link to="/" className="link" onClick>
                <Items Icon={Home} text="Home" />
              </Link>

              <Link to="/discover" className="link">
                <Items Icon={Search} text="Discover" />
              </Link>

              <Link to="/profile" className="link">
                <Items Icon={Person} text="Profile" />
              </Link>
            </ul>
          </div>
          {localStorage?.role === 'ROLE_ADMIN' && (
            <div className="sidebarMenu">
              <h3 className="sidebarTitle">Admin Menu</h3>
              <ul className="sidebarList">
                <Link to="/users" className="link">
                  <Items Icon={PeopleAlt} text="Users" />
                </Link>

                <Link to="/groups" className="link">
                  <Items Icon={Forum} text="Groups" />
                </Link>

                <Link to="/topics" className="link">
                  <Items Icon={Assignment} text="Topics" />
                </Link>
              </ul>
            </div>
          )}
        </div>
      </div>
    );
  }
  return (
    <div className="sidebar">
      <div className="sidebarWrapper">
        <div className="sidebarMenu">
          <h3 className="sidebarTitle">Dashboard</h3>
          <ul className="sidebarList">
            <Link to="/welcome" className="link" onClick>
              <Items Icon={CheckBox} text="Welcome" />
            </Link>

            <Link to="/login" className="link">
              <Items Icon={PersonAdd} text="Login" />
            </Link>
          </ul>
        </div>
      </div>
    </div>
  );
}
