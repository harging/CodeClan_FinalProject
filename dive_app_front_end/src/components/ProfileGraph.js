import React from 'react'
import Highcharts from 'highcharts'
import HighchartsReact from 'highcharts-react-official'

const ProfileGraph = ({ samplePoints, dive }) => {
  if (!samplePoints.length || !dive) {
    return null
  }

  const depths = samplePoints.map((samplePoint) => samplePoint.depth)

  const options = {
    chart: {
      backgroundColor: 'rgba(0,0,0,0)'
    },

    title: {
      text: 'Dive profile'
    },

    yAxis: {
      reversed: true,
      title: {
        text: 'Depth'
      }
    },

    xAxis: {
      accessibility: {
        rangeDescription: 'Depth'
      }
    },

    legend: {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'middle'
    },

    plotOptions: {
      series: {
        label: {
          connectorAllowed: false
        },
        pointStart: 0
      }
    },
    series: [
      {
        name: 'Gavin',
        data: depths
      }
    ],

    responsive: {
      rules: [
        {
          condition: {
            maxWidth: 500
          },
          chartOptions: {
            legend: {
              layout: 'horizontal',
              align: 'center',
              verticalAlign: 'bottom'
            }
          }
        }
      ]
    }
  }

  return (
    <>
      <HighchartsReact highcharts={Highcharts} options={options} />
    </>
  )
}

export default ProfileGraph
