import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"查看设备", menuFor: "viewDevice",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  longitude: '经度',
  latitude: '纬度',
  height: '高度',
  platform: '平台',
  createTime: '创建时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '12',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.height, debugtype: 'int', dataIndex: 'height', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.platform, dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({viewDevice,targetComponent})=>{

	
	
	const {ViewDeviceService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{viewDevice.id}</Description> 
<Description term="名称">{viewDevice.name}</Description> 
<Description term="经度">{viewDevice.longitude}</Description> 
<Description term="纬度">{viewDevice.latitude}</Description> 
<Description term="高度">{viewDevice.height}</Description> 
<Description term="创建时间">{ moment(viewDevice.createTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(viewDevice,targetComponent)}
      </DescriptionList>
	)

}
	



const ViewDeviceBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ViewDeviceBase



