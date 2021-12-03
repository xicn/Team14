import React from 'react';
import './item.css';

export default function Items({ Icon, text, active }) {
  // const [state, setstate] = useState(active);

  return (
    <div>
      <li className={active ? 'sidebarListItem active' : 'sidebarListItem'}>
        <Icon className="sidebarIcon" />
        {text}
      </li>
    </div>
  );
}
