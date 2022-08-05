import { render } from '@testing-library/react'
import App from './App'

test('logo is on page', () => {
  expect(getByText('diveLogger')).toBeInTheDocument()
})
