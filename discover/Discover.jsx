import React from 'react';
import './discover.css';
import { DataGrid } from '@material-ui/data-grid';
import { DeleteOutline } from '@material-ui/icons';
import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';

export default function Discover() {
  // return (
  //   <div className="discoverPage">
  //     <h1>Discover</h1>
  //   </div>
  // );

  const [groups, setGroups] = useState([]);

  useEffect(() => {
    let isMounted = true;
    axios('http://localhost:8080/api/v1/groups/getAllGroups').then((result) => {
      // Set state to results fetched from API
      if (isMounted) setGroups(result.data);
      console.log(result.data);
    });
    return () => {
      isMounted = false;
    };
  }, []);

  // Deletes topics in the database
  const handleDelete = (id) => {
    setGroups(groups.filter((item) => item.topicID !== id));
    axios
      .delete('http://localhost:8080/api/v1/groups/deleteById/' + id)
      .then((result) => console.log(result));
  };

  const columns = [
    { field: 'groupID', headerName: 'Group ID', width: 300 },
    { field: 'topicID', headerName: 'Topic ID', width: 300 },
    { field: 'name', headerName: 'Title', width: 150 },
    { field: 'description', headerName: 'Description', width: 150 },
    {
      field: 'action',
      headerName: 'Action',
      width: 150,
      renderCell: (params) => {
        return (
          <>
            <Link to={'/group/' + params.row.groupID}>
              <button className="userListEdit">Edit</button>
            </Link>
            <DeleteOutline
              className="userListDelete"
              onClick={() => handleDelete(params.row.groupID)}
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
                {/* <h1>Welcome to HuskyGroups!</h1> */}
                <p>
                  Look through the table for a group to join! Can't find one? Try sorting the list below by its topic or name! 
                </p>
                {/* <form action="search.php" role="search" id="form" method="GET"> */}
                {/* <input type="text" class="search" name="search" id="query" name="q"
                 placeholder="Search..."
                 aria-label="Search for a group"/> */}
                  {/* <div id="search_button_container"></div> */}
                  <div className="users">
                  <div className="userTitleContainer">
                  <h1 className="userTitle">Groups</h1>
                  </div>
      <DataGrid
        rows={groups}
        disableSelectionOnClick
        columns={columns}
        pageSize={8}
        checkboxSelection
        getRowId={(row) => row.groupID}
      />
    </div>
              {/* </form> */}
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
