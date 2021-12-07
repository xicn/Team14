import React from 'react';
import Chart from '../../components/chart/Chart';
import FeaturedInfo from '../../components/featureInfo/FeaturedInfo';
import WidgetSm from '../../components/widgetSm/WidgetSm';
import WidgetLg from '../../components/widgetLg/WidgetLg';
import './home.css';
import { userData } from '../../data/dummy';
import Login from '../login/Login';

export default function Home() {
  // return (
  //   <div className="homePage">
  //     <FeaturedInfo />
  //     <Chart
  //       data={userData}
  //       title="User Analytics"
  //       grid
  //       dataKey="Active User"
  //     />
  //     <div className="homeWidget">
  //       <WidgetSm />
  //       <WidgetLg />
  //     </div>
  //   </div>
  // );
  return (
    <div className="homePage">
      <h1 className="title" style={{ color: 'white' }}>
        Home
      </h1>
      <Login />
    </div>
  );
}
