import React from 'react';
import { DataGrid } from '@material-ui/data-grid';
import { DeleteOutline } from '@material-ui/icons';
import { Link, useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';
import './profile.css';

export default function Profile() {
  const [data, setData] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    let isMounted = true;
    axios('http://localhost:8080/api/v1/users/getAllUsers').then((result) => {
      if (isMounted) setData(result.data);
      console.log(result.data);
    });
    return () => {
      isMounted = false;
    };
  }, []);

  const handleDelete = (id) => {
    setData(data.filter((item) => item.id !== id));
    axios
      .delete('http://localhost:8080/api/v1/users/deleteById/' + id)
      .then((result) => console.log(result));
  };

  const columns = [
    { field: 'id', headerName: 'ID', width: 300 },
    {
      field: 'link',
      headerName: 'User',
      width: 10,
      renderCell: (params) => {
        return (
          <div className="userListUser">
            <img className="userListImg" src={params.row.link} alt="" />
            {params.row.username}
          </div>
        );
      },
    },
    { field: 'firstName', headerName: 'First Name', width: 150 },
    { field: 'lastName', headerName: 'First Name', width: 150 },

    { field: 'email', headerName: 'Email', width: 200 },
    {
      field: 'description',
      headerName: 'Description',
      width: 160,
    },
    {
      field: 'action',
      headerName: 'Action',
      width: 150,
      renderCell: (params) => {
        return (
          <>
            <Link to={'/user/' + params.row.id}>
              <button className="userListEdit">Edit</button>
            </Link>
            <DeleteOutline
              className="userListDelete"
              onClick={() => handleDelete(params.row.id)}
            />
          </>
        );
      },
    },
  ];

  return (
<div>
<meta charSet="UTF-8" />
<meta httpEquiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Welcome Page</title>
<link rel="stylesheet" href="style.css" />
{/*<title> Responsive Footer | CodingLab</title>-*/}
<link rel="stylesheet" href="style.css" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
<div className="main">
  <div className="main___home">
    <div className="main__stuff">
      <h1>Profile</h1>
      <p>
      This is where you can view your groups and see more information about them. You can also look at your username.
      </p>
      <div className="users">
      <div className="userTitleContainer">
        {/* <h1 className="userTitle">User</h1> */}
      </div>
      {/* <div className="headline">
        <h1>Users</h1>
        <Link to="/newUser">
          <button
            className="newUserButton"
            style={{ marginTop: 0, marginLeft: 20, padding: '7px 10px' }}
          >
            Create
          </button>
        </Link>
        <div className="inBetween"></div>
      </div> */}

      <DataGrid
        rows={data}
        disableSelectionOnClick
        columns={columns}
        pageSize={8}
        checkboxSelection
      />
    </div>
    </div>
  </div>
</div>
<footer>
  <div className="content">
    <div className="left box">
      <div className="upper">
        <div className="topic">About us</div>
        <p>HuskyGroups is a platform where you can find resources for classes, clubs
          or even other groups at Michigan Tech. You can find new groups to join or
          even create your own. 
        </p>
      </div>
      <div className="lower">
        <div className="topic">Suggestions? Contact -</div>
        <div className="email">
          <a href="#"><i className="fas fa-envelope" />HuskyGroups@gmail.com</a>
        </div>
      </div>
    </div>
    <div className="middle box">
      <div className="topic">Other MTU Services</div>
      <div><a href="https://sso.mtu.edu/cas/login?service=https%3A%2F%2Fmymichigantech.mtu.edu%2Fc%2Fportal%2Flogin">My MichiganTech</a></div>
      <div><a href="https://sso.mtu.edu/cas/login?service=https%3A%2F%2Fwww.banweb.mtu.edu%3A443%2Fssomanager%2Fc%2FSSB">Banweb</a></div>
      <div><a href="https://sso.mtu.edu/cas/login?service=https%3A%2F%2Fmtu.instructure.com%2Flogin%2Fcas%2F759">Canvas</a></div>
    </div>
    <div className="right box">
      <div className="topic">Social media</div>
      <form action="#">
        <div className="media-icons">
          <a href="#"><i className="fab fa-facebook-f" /></a>
          <a href="#"><i className="fab fa-instagram" /></a>
          <a href="#"><i className="fab fa-twitter" /></a>
          <a href="#"><i className="fab fa-youtube" /></a>
          <a href="#"><i className="fab fa-linkedin-in" /></a>
        </div>
      </form>
    </div>
  </div>
  <div className="bottom">
    <p>Copyright © 2021 <a href="#">HuskyGroups</a> All rights reserved</p>
  </div>
</footer>
</div>
  );
}
