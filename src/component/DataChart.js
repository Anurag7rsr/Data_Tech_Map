import React, { useEffect, useState } from 'react';
import { fetchData } from '../services/apiService';

function DataChart() {
  const [data, setData] = useState([]);

  useEffect(() => {
    fetchData()
      .then(response => {
        setData(response);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <h3>Data Chart</h3>
      <pre>{JSON.stringify(data, null, 2)}</pre>
      {/* Placeholder for chart */}
    </div>
  );
}

export default DataChart;
