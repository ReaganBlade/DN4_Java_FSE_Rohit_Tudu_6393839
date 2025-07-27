import React from 'react';
import styles from './CohortDetails.module.css';

const CohortDetails = ({ data }) => {
  const headingStyle = {
    color: data.status === 'Ongoing' ? 'green' : 'blue'
  };

  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{data.name}</h3>
      <dl>
        <dt>Started On</dt>
        <dd>{data.startedOn}</dd>
        <dt>Current Status</dt>
        <dd>{data.status}</dd>
        <dt>Coach</dt>
        <dd>{data.coach}</dd>
        <dt>Trainer</dt>
        <dd>{data.trainer}</dd>
      </dl>
    </div>
  );
};

export default CohortDetails;