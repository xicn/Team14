import Sidebar from './components/sidebar/Sidebar';
import Topbar from './components/topbar/Topbar';
import './app.css';
import Home from './page/home/Home';
import { Routes, Route } from 'react-router-dom';
import Discover from './page/discover/Discover';
import Profile from './page/profile/Profile';
import Users from './page/admin_user/users/Users';
import Groups from './page/admin_group/groups/Groups';
import Topics from './page/admin_topic/topics/Topics';
import NewUser from './page/admin_user/newUser/NewUser';
import User from './page/admin_user/user/User';
import NewTopic from './page/admin_topic/newTopic/NewTopic';
import NewGroup from './page/admin_group/newGroup/NewGroup';
import Group from './page/admin_group/group/Group';
import AddUserToGroup from './page/membership/AddUserToGroup';
import { PrivateRoute } from './auth/PrivateRoute.tsx';
import { getCurrentUser, ROLE } from './auth/LoginUtil';
import Login from './page/login/Login';
import { useState } from 'react';
import Welcome from './page/welcome/Welcome';

function App() {
  const [loggedIn, setloggedIn] = useState(false);
  const currentUser = getCurrentUser();
  console.log(currentUser);

  const handleLogOut = () => {
    localStorage.clear();
    if (loggedIn) {
      setloggedIn(false);
    }
  };

  const handleLogIn = () => {
    setloggedIn(true);
  };

  return (
    <div className="App">
      <Topbar
        logOut={handleLogOut}
        imgLink={currentUser.img}
        loggedIn={loggedIn}
      />
      <div className="container">
        <Sidebar loggedIn={loggedIn} />
        {/* <div className="left"> */}
        <Routes>
          <Route
            path="/"
            element={
              <PrivateRoute
                roles={[ROLE.ADMIN, ROLE.USER]}
                component={Home}
                loggedIn={handleLogIn}
              />
            }
          />
          <Route
            path="/discover"
            element={
              <PrivateRoute
                roles={[ROLE.ADMIN, ROLE.USER]}
                component={Discover}
                loggedIn={handleLogIn}
              />
            }
          />
          <Route
            path="/profile"
            element={
              <PrivateRoute
                roles={[ROLE.ADMIN, ROLE.USER]}
                component={Profile}
                loggedIn={handleLogIn}
              />
            }
          />

          <Route
            path="/users"
            element={
              <PrivateRoute
                roles={[ROLE.ADMIN]}
                component={Users}
                loggedIn={handleLogIn}
              />
            }
          />
          <Route
            path="/groups"
            element={
              <PrivateRoute
                roles={[ROLE.ADMIN]}
                component={Groups}
                loggedIn={handleLogIn}
              />
            }
          />
          <Route
            path="/topics"
            element={
              <PrivateRoute
                roles={[ROLE.ADMIN]}
                component={Topics}
                loggedIn={handleLogIn}
              />
            }
          />

          <Route path="/newUser" element={<NewUser />} />
          <Route path="/newTopic" element={<NewTopic />} />
          <Route path="/newGroup" element={<NewGroup />} />

          <Route path="/user/:userId" element={<User />} />
          <Route path="/group/:groupId" element={<Group />} />

          <Route path="/AddUserToGroup" element={<AddUserToGroup />} />

          <Route path="/login" element={<Login setloggedIn={handleLogIn} />} />
          {/* <Route path="/logout" element={<LogOut logOut={handleLogOut} />} /> */}
          <Route
            path="/welcome"
            element={<Welcome setloggedIn={handleLogIn} />}
          />
        </Routes>
      </div>
      {/* </div> */}
    </div>
  );
}

export default App;
