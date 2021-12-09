import React from 'react';
import { getCurrentUser } from '../../auth/LoginUtil';
import './home.css';
import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';
import 'react-draft-wysiwyg/dist/react-draft-wysiwyg.css';
import GroupCard from '../../components/groupCard/GroupCard';
import { getHeaderWithOnlyJwtAuth } from '../../util/request';

export default function Home() {
  const [data, setData] = useState([]);
  const [change, setChange] = useState(true);

  useEffect(() => {
    let isMounted = true;
    axios(
      'http://localhost:8080/api/v1/self/getUser',
      getHeaderWithOnlyJwtAuth(localStorage.getItem('auth'))
    ).then((result) => {
      if (isMounted) setData(result.data);
      console.log(result);
    });
    return () => {
      isMounted = false;
    };
  }, []);

  // let groupReq = {
  //   name: 'Group 1',
  //   topicID: '3dd9ccfa-26c0-472c-bce7-a6d7cbc68f15',
  //   description: 'This is a test run!',
  // };
  // useEffect(() => {
  //   axios
  //     .post(
  //       'http://localhost:8080/api/v1/self/createGroup',
  //       groupReq,
  //       getHeaderWithOnlyJwtAuth(localStorage.getItem('auth'))
  //     )
  //     .then((result) => {
  //       console.log(result);
  //     })
  //     .catch(console.error);
  // }, []);

  return (
    <div className="homePage" style={{ paddingRight: '20px' }}>
      <h1 className="title" style={{ color: 'white' }}>
        Welcome back {getCurrentUser().name} 👋 !
      </h1>
      <div
        className="groupContainer"
        style={{ color: '#555', backgroundColor: 'white', maxWidth: 1200 }}
      >
        <span className="userUpdateTitle">Groups</span>
        <Link to="/discover">
          <button
            className="userAddButton"
            style={{
              marginLeft: '20px',
              backgroundColor: 'rgba(255, 206, 0, 255)',
            }}
          >
            Join
          </button>
        </Link>
        <Link to="/createGroup">
          <button
            className="userAddButton"
            style={{
              marginLeft: '20px',
              backgroundColor: 'rgba(255, 206, 0, 255)',
            }}
          >
            Create
          </button>
        </Link>
        <div className="cardsContainer">
          {data.groups?.map((item, i) => {
            return (
              <GroupCard
                key={i}
                name={item.groupName}
                description={item.groupDescription}
                userId={item.userId}
                groupId={item.groupId}
                roleNum={item.groupRole}
                groupRole={item.groupRole}
              />
            );
          })}
        </div>
      </div>
    </div>
  );
}
