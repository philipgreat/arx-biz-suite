

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
import styles from './TargetObject.preference.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (targetObject,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{targetObject.id}</Description> 
<Description term="名称">{targetObject.name}</Description> 
<Description term="经度">{targetObject.longitude}</Description> 
<Description term="纬度">{targetObject.latitude}</Description> 
<Description term="高度">{targetObject.height}</Description> 
<Description term="文本内容">{targetObject.textContent}</Description> 
<Description term="创建时间">{ moment(targetObject.createTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = targetObject => {
  const {TargetObjectBase} = GlobalComponents
  return <PermissionSetting targetObject={targetObject}  targetObjectMeta={TargetObjectBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class TargetObjectPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  targetObject = this.props.targetObject;
    const { id,displayName,  } = targetObject
    const cardsData = {cardsName:"目标对象",cardsFor: "targetObject",cardsSource: targetObject,
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
  targetObject: state._targetObject,
}))(Form.create()(TargetObjectPermission))

