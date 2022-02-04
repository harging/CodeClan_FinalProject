const DiveSelect = ({ dives, onDiveSelected }) => {

    return (
        <ul>
            {dives.map(dive => {
                return (
                    <li key={dive.id}>
                        {dive.diveNum}<button onClick={() => onDiveSelected(dive.id)}>View</button>
                    </li>
                )
            })}
        </ul>
    )
}

export default DiveSelect