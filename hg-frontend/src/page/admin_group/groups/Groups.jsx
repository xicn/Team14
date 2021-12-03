import React from 'react';
import './groups.css';
import { DataGrid } from '@material-ui/data-grid';
import { DeleteOutline } from '@material-ui/icons';
import { Link } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';

export default function Groups() {
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
    <div className="users">
      <div className="userTitleContainer">
        <h1 className="userTitle">Groups</h1>
        <Link to="/newGroup">
          <button className="userAddButton">Create</button>
        </Link>
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
  );
}
