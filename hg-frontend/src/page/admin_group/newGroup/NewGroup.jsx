import React from 'react';
import './newGroup.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { useState, useEffect } from 'react';

export default function NewGroup() {
  const navigate = useNavigate();
  const [topics, setTopics] = useState([]);

  useEffect(() => {
    let isMounted = true;
    axios('http://localhost:8080/api/v1/topics/getAllTopics').then((result) => {
      // Set state to results fetched from API
      if (isMounted) setTopics(result.data);
      console.log(result.data);
    });
    return () => {
      isMounted = false;
    };
  }, []);

  const handleSubmit = (event) => {
    event.preventDefault();
    const name = event.target.elements.name.value;
    const description = event.target.elements.description.value;
    const topicID = event.target.elements.topicID.value;
    console.log({ name, description, topicID });

    axios
      .post(
        'http://localhost:8080/api/v1/groups/createGroup',
        {
          name,
          description,
          topicID,
        },
        {
          headers: {
            'Content-Type': 'application/json',
          },
        }
      )
      .then(function (response) {
        console.log(response);
        navigate({ pathname: '/groups' });
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="newUser">
      <h1 className="newUserTitle">New Group</h1>
      <form className="newUserForm" onSubmit={handleSubmit}>
        <div className="newUserItem">
          <label>Title</label>
          <input type="text" placeholder="CS3141 Study Group" name="name" />
        </div>
        <div className="newUserItem">
          <label>Description</label>
          <input
            type="text"
            placeholder="Description goes here!"
            name="description"
          />
        </div>
        <div className="newUserItem">
          <label>Topic ID</label>
          <input type="text" placeholder="Topic id goes here!" name="topicID" />
        </div>

        <button className="newUserButton">Create</button>
      </form>
    </div>
  );
}
