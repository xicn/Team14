import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

const useStyles = makeStyles({
  root: {
    marginTop: '20px',
    maxWidth: 345,
  },
  action: {
    display: 'flex',
    alignItems: 'space-around',
    justifyContent: 'left',
  },
  image: {
    margin: '0',
    width: '80px',
    height: '80px',
  },
  title: {},
});

export default function UserCard({ link, name }) {
  const classes = useStyles();

  return (
    <Card className={classes.root}>
      <CardActionArea className={classes.action}>
        <img
          src={link}
          alt=""
          className="userShowImg"
          style={{ marginLeft: '20px' }}
        />
        <CardContent>
          <Typography gutterBottom variant="h6" component="h2">
            {name}
          </Typography>
          {/* <Typography variant="body2" color="textSecondary" component="p">
            {description}
          </Typography> */}
        </CardContent>
        {/* <CardMedia
          className={classes.image}
          component="img"
          alt="Contemplative Reptile"
          image="https://cdn.pixabay.com/photo/2016/11/14/17/39/group-1824145_1280.png"
          title="Contemplative Reptile"
        /> */}
      </CardActionArea>
      <CardActions>
        <Button size="small" color="primary">
          Open
        </Button>
        <Button size="small" color="warning">
          Leave
        </Button>
      </CardActions>
    </Card>
  );
}
