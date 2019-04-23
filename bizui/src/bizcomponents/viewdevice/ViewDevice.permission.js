

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ViewDevice.preference.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (viewDevice,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{viewDevice.id}</Description> 
<Description term="名称">{viewDevice.name}</Description> 
<Description term="经度">{viewDevice.longitude}</Description> 
<Description term="纬度">{viewDevice.latitude}</Description> 
<Description term="高度">{viewDevice.height}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = viewDevice => {
  const {ViewDeviceBase} = GlobalComponents
  return <PermissionSetting targetObject={viewDevice}  targetObjectMeta={ViewDeviceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ViewDevicePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  viewDevice = this.props.viewDevice;
    const { id,displayName,  } = viewDevice
    const cardsData = {cardsName:"查看设备",cardsFor: "viewDevice",cardsSource: viewDevice,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  viewDevice: state._viewDevice,
}))(Form.create()(ViewDevicePermission))

