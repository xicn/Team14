import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const useStyles = makeStyles({
  root: {
    marginTop: '20px',
    maxWidth: 345,
  },
});

export default function GroupCard({
  name,
  description,
  userId,
  groupId,
  memberId,
}) {
  const classes = useStyles();
  const navigate = useNavigate();
  const handleLeave = () => {
    axios
      .delete(
        'http://localhost:8080/api/v1/DeleteFromGroup',
        {
          membershipID: memberId,
        },
        {
          headers: {
            'Content-Type': 'application/json',
          },
        }
      )
      .then(function (response) {
        console.log(response);
        // navigate({ pathname: '/groups' });
      })
      .catch(function (error) {
        console.log(error);
      });
  };

  return (
    <Card className={classes.root}>
      <CardActionArea>
        <CardMedia
          component="img"
          alt="Contemplative Reptile"
          height="140"
          image="https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_1280.png"
          title="Contemplative Reptile"
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="h2">
            {name}
          </Typography>
          <Typography variant="body2" color="textSecondary" component="p">
            {description}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Link to={'/group/' + groupId}>
          <Button size="small" color="primary">
            Open
          </Button>
        </Link>

        <Button size="small" color="warning" onClick={handleLeave}>
          Leave
        </Button>
      </CardActions>
    </Card>
  );
}
