import React from 'react';
import './topics.css';
import { DataGrid } from '@material-ui/data-grid';
import { DeleteOutline } from '@material-ui/icons';
import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';

export default function Topics() {
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

  // Deletes topics in the database
  const handleDelete = (id) => {
    setTopics(topics.filter((item) => item.topicID !== id));
    axios
      .delete('http://localhost:8080/api/v1/topics/deleteById/' + id)
      .then((result) => console.log(result));
  };

  const columns = [
    { field: 'topicID', headerName: 'ID', width: 300 },
    { field: 'name', headerName: 'Title', width: 150 },
    { field: 'description', headerName: 'Description', width: 150 },
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
              onClick={() => handleDelete(params.row.topicID)}
            />
          </>
        );
      },
    },
  ];
  return (
    <div className="users">
      <div className="userTitleContainer">
        <h1 className="userTitle">Topics</h1>
        <Link to="/newTopic">
          <button className="userAddButton">Create</button>
        </Link>
      </div>
      <DataGrid
        rows={topics}
        disableSelectionOnClick
        columns={columns}
        pageSize={8}
        checkboxSelection
        getRowId={(row) => row.topicID}
      />
    </div>
  );
}
