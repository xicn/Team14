import React from 'react';
import './sidebar.css';
import {
  Forum,
  Home,
  Assignment,
  PeopleAlt,
  Person,
  Search,
} from '@material-ui/icons';
import Items from './Items';
import { Link } from 'react-router-dom';

export default function Sidebar() {
  // const [active, setActive] = useState(false);
  // const onState = () => setActive(!active);
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
      </div>
    </div>
  );
}
