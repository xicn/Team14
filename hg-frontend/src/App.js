import Sidebar from './components/sidebar/Sidebar';
import Topbar from './components/topbar/Topbar';
import './app.css';
import Home from './page/home/Home';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
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

function App() {
  return (
    <Router className="App">
      <Topbar />
      <div className="container">
        <Sidebar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/discover" element={<Discover />} />
          <Route path="/profile" element={<Profile />} />

          <Route path="/users" element={<Users />} />
          <Route path="/groups" element={<Groups />} />
          <Route path="/topics" element={<Topics />} />

          <Route path="/newUser" element={<NewUser />} />
          <Route path="/newTopic" element={<NewTopic />} />
          <Route path="/newGroup" element={<NewGroup />} />

          <Route path="/user/:userId" element={<User />} />
          <Route path="/group/:groupId" element={<Group />} />

          <Route path="/AddUserToGroup" element={<AddUserToGroup />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
