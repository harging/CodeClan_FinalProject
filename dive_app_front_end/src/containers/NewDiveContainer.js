import ReactDOM from 'react-dom';

function NewDiveContainer () {
    return (
      <form>
        <label>Date:
          <input type="date" />
        </label>
        <label>Place:
          <input type="text" />
        </label>
      </form>
    )
  }

  ReactDOM.render(<NewDiveContainer />, document.getElementById('root'));
  export default NewDiveContainer;