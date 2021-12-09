import React from 'react';
import './profile.css';
import { Edit, MailOutline, PermIdentity } from '@material-ui/icons';
import { useState, useEffect } from 'react';
import axios from 'axios';
import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';
import { getHeaderWithOnlyJwtAuth } from '../../util/request';

export default function Profile() {
  const [data, setData] = useState([]);
  const [change, setChange] = useState(true);

  useEffect(() => {
    let isMounted = true;
    axios(
      'http://localhost:8080/api/v1/self/getUser',
      getHeaderWithOnlyJwtAuth(localStorage.getItem('auth'))
    ).then((result) => {
      if (isMounted) setData(result.data);
      // console.log(result.data);
    });
    return () => {
      isMounted = false;
    };
  }, [change]);

  const handleSubmit = (event) => {
    event.preventDefault();
    const firstName = event.target.elements.firstName.value;
    const lastName = event.target.elements.lastName.value;
    const email = data.email;
    const description = event.target.elements.description.value;
    const link = event.target.elements.link.value;
    const UserDTO = {
      id: data?.id,
      firstName: firstName ? firstName : data.firstName,
      lastName: lastName ? lastName : data.lastName,
      email: email ? email : data.email,
      description: description ? description : data.description,
      link: link ? link : data.link,
    };

    axios
      .put(
        'http://localhost:8080/api/v1/self/update',
        UserDTO,
        getHeaderWithOnlyJwtAuth(localStorage.getItem('auth'))
      )
      .then(function (response) {
        setChange(!change);
        localStorage.setItem('img', response.data.link);
      })
      .catch(function (error) {
        console.log(error);
      });
  };
  return (
    <div className="profilePage" style={{ paddingRight: '20px' }}>
      <div className="userTitleContainer">
        <div className="titleContainer">
          <h1 className="userTitle">Profile</h1>
        </div>
      </div>
      <div className="userContainer">
        <div
          className="userShow"
          style={{
            backgroundColor: 'white',
            color: '#555',
          }}
        >
          <div className="userShowTop">
            <img
              src={
                data?.link
                  ? data.link
                  : 'https://images.unsplash.com/photo-1590272456521-1bbe160a18ce?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MTl8fHxlbnwwfHx8fA%3D%3D&w=1000&q=80'
              }
              alt=""
              className="userShowImg"
              style={{ border: '3px solid rgba(255, 206, 0, 255)' }}
            />
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
              <span className="userShowInfoTitle">{data.description}</span>
            </div>
          </div>
        </div>
        <div
          className="userUpdate"
          style={{
            backgroundColor: 'white',
            color: '#555',
          }}
        >
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
              {/* <div className="userUpdateItem">
                <label>Email</label>
                <input
                  type="text"
                  placeholder="jondow@mtu.edu"
                  className="userUpdateInput"
                  name="email"
                />
              </div> */}
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
            <div className="userUpdateRight"></div>
            <button
              className="userUpdateButton"
              style={{ backgroundColor: 'rgba(255, 206, 0, 255)' }}
            >
              Update
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
