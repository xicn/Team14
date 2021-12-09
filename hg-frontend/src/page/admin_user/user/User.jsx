import { Edit, MailOutline, PermIdentity, Undo } from '@material-ui/icons';
import { Link, useParams } from 'react-router-dom';
import './user.css';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';
import GroupCard from '../../../components/groupCard/GroupCard';

export default function User() {
  const navigate = useNavigate();
  const { userId } = useParams();
  console.log(userId);
  const [data, setData] = useState([]);
  const [change, setChange] = useState(true);

  useEffect(() => {
    let isMounted = true;
    axios('http://localhost:8080/api/v1/users/getById/' + userId).then(
      (result) => {
        if (isMounted) setData(result.data);
        console.log(result.data);
      }
    );
    return () => {
      isMounted = false;
    };
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();
    const firstName = event.target.elements.firstName.value;
    const lastName = event.target.elements.lastName.value;
    const email = event.target.elements.email.value;
    const description = event.target.elements.description.value;
    const link = event.target.elements.link.value;
    console.log(firstName, lastName, link);
    const UserDTO = {
      id: userId,
      firstName: firstName ? firstName : data.firstName,
      lastName: lastName ? lastName : data.lastName,
      email: email ? email : data.email,
      description: description ? description : data.description,
      link: link ? link : data.link,
    };

    // console.log(obj);
    axios
      .put('http://localhost:8080/api/v1/users/update', UserDTO, {
        headers: {
          'Content-Type': 'application/json',
        },
      })
      .then(function (response) {
        console.log(response);
        setChange(!change);
        navigate({ pathname: '/users' });
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="user">
      <div className="userTitleContainer">
        <div className="titleContainer">
          <h1 className="userTitle">Edit User</h1>
          <Link
            to="/users"
            style={{ textDecoration: 'none', color: 'inherit' }}
          >
            <Undo className="undoBut" />
          </Link>
        </div>
        <Link to="/newUser">
          <button className="userAddButton">Create</button>
        </Link>
      </div>
      <div className="userContainer">
        <div className="userShow">
          <div className="userShowTop">
            <img src={data.link} alt="" className="userShowImg" />
            <div className="userShowTopTitle">
              <span className="userShowUsername">
                {data.firstName + ' ' + data.lastName}
              </span>
            </div>
          </div>
          <div className="userShowBottom">
            <span className="userShowTitle">Account Details</span>
            <div className="userShowInfo">
              <PermIdentity className="userShowIcon" />
              <span className="userShowInfoTitle">{data.id}</span>
            </div>

            <span className="userShowTitle">Contact Details</span>

            <div className="userShowInfo">
              <MailOutline className="userShowIcon" />
              <span className="userShowInfoTitle">{data.email}</span>
            </div>

            <span className="userShowTitle">Description</span>

            <div className="userShowInfo">
              <Edit className="userShowIcon" />
              <span className="userShowInfoTitle">{data.email}</span>
            </div>
          </div>
        </div>
        <div className="userUpdate">
          <span className="userUpdateTitle">Edit</span>
          <form className="userUpdateForm" onSubmit={handleSubmit}>
            <div className="userUpdateLeft">
              <div className="userUpdateItem">
                <label>First Name</label>
                <input
                  type="text"
                  placeholder="Jon"
                  className="userUpdateInput"
                  name="firstName"
                />
              </div>
              <div className="userUpdateItem">
                <label>Last Name</label>
                <input
                  type="text"
                  placeholder="Dow"
                  className="userUpdateInput"
                  name="lastName"
                />
              </div>
              <div className="userUpdateItem">
                <label>Email</label>
                <input
                  type="text"
                  placeholder="jondow@mtu.edu"
                  className="userUpdateInput"
                  name="email"
                />
              </div>
              <div className="userUpdateItem">
                <label>Description</label>
                <input
                  type="text"
                  placeholder="Describe yourself"
                  className="userUpdateInput"
                  name="description"
                />
              </div>
              <div className="userUpdateItem">
                <label>Profile Picture</label>
                <input
                  type="text"
                  placeholder="Please enter a valid image url here"
                  className="userUpdateInput"
                  name="link"
                />
              </div>
            </div>
            <div className="userUpdateRight">
              {/* <div className="userUpdateUpload">
                <img
                  className="userUpdateImg"
                  src="https://images.pexels.com/photos/1152994/pexels-photo-1152994.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500"
                  alt=""
                />
                <label htmlFor="file">
                  <Publish className="userUpdateIcon" />
                </label>
                <input type="file" id="file" style={{ display: 'none' }} />
              </div> */}

              {/* <div
                style={{
                  // border: '1px solid gray',
                  marginLeft: '20px',
                  padding: '2px',
                  minHeight: '300px',
                  minWidth: '200px',
                }}
                className="userUpdateItem"
              >
                <label>Description</label>
                <Editor
                  editorState={editorState}
                  onEditorStateChange={setEditorState}
                  className="userUpdateInput"
                />
              </div> */}
            </div>
            <button className="userUpdateButton">Update</button>
          </form>
        </div>
      </div>
      <div className="groupContainer">
        <span className="userUpdateTitle">Groups</span>
        <Link to="/AddUserToGroup">
          <button className="userAddButton" style={{ marginLeft: '20px' }}>
            Join
          </button>
        </Link>
        <div className="cardsContainer">
          {data.groups?.map((item, i) => {
            console.log('test');
            return (
              <GroupCard
                key={i}
                name={item.groupName}
                description={item.groupDescription}
                userId={item.userId}
                groupId={item.groupId}
              />
            );
          })}
        </div>
      </div>
    </div>
  );
}
