import React, { useState } from 'react';
import SearchBar from 'material-ui-search-bar';
import './discover.css';

export default function Discover() {
  const [searchItem, setSearchItem] = useState('');
  return (
    <div className="discoverPage">
      <h1>Discover</h1>
      <SearchBar
        value={searchItem}
        onChange={(value) => {
          setSearchItem(value);
        }}
        onRequestSearch={() => console.log('onRequestSearch')}
        style={{
          // margin: '0 auto',
          maxWidth: 800,
          marginTop: '20px',
        }}
      />
    </div>
  );
}
