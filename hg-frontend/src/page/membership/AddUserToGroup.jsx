import React from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function AddUserToGroup() {
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    const groupId = event.target.elements.groupId.value;
    const userId = event.target.elements.userId.value;
    console.log({ userId, groupId });

    axios
      .post(
        'http://localhost:8080/api/v1/users/addToGroup',
        {
          groupId,
          userId,
        },
        {
          headers: {
            'Content-Type': 'application/json',
          },
        }
      )
      .then(function (response) {
        console.log(response);
        navigate({ pathname: '/users' });
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <div className="newUser">
      <h1 className="newUserTitle">New Membership</h1>
      <form className="newUserForm" onSubmit={handleSubmit}>
        <div className="newUserItem">
          <label>Group ID</label>
          <input type="text" placeholder="Group id goes here!" name="groupId" />
        </div>
        <div className="newUserItem">
          <label>User ID</label>
          <input type="text" placeholder="User id goes here!" name="userId" />
        </div>

        <button className="newUserButton">Create</button>
      </form>
    </div>
  );
}
