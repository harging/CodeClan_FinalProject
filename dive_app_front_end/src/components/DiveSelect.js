import React from 'react';

const DiveSelect = ({ dives, onDiveSelected }) => {

    // Why can't I add the date consts from the Dive component?

    return (
        <ul>
            {dives.map(dive => {
                return (
                    <li key={dive.id} className="diveListItem">
                        <button  onClick={() => onDiveSelected(dive.id)}>
                            {dive.diveNum} - {dive.place}, {dive.diveSite}
                        </button>
                    </li>
                )
            })}
        </ul>
    )
}


export default DiveSelect