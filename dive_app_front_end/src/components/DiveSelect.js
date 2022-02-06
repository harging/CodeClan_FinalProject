const DiveSelect = ({ dives, onDiveSelected }) => {

    // Why can't I make the whole li a button by wrapping it in the button tag?
    // Why can't I add the date consts from the Dive component?

    return (
        <ul>
            {dives.map(dive => {
                return (
                    <li key={dive.id} className="diveListItem">
                        {dive.diveNum} - {dive.place}, {dive.diveSite} <button onClick={() => onDiveSelected(dive.id)}>View</button>
                    </li>
                )
            })}
        </ul>
    )
}


export default DiveSelect