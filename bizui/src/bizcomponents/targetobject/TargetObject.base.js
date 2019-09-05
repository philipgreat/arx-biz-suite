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


const menuData = {menuName:"目标对象", menuFor: "targetObject",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  longitude: '经度',
  latitude: '纬度',
  height: '高度',
  textContent: '文本内容',
  imagePath: '图片路径',
  platform: '平台',
  createTime: '创建时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '12',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.height, debugtype: 'int', dataIndex: 'height', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.textContent, debugtype: 'string', dataIndex: 'textContent', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: fieldLabels.imagePath, dataIndex: 'imagePath', render: (text, record) => renderImageCell(text,record,'图片路径') },
  { title: fieldLabels.platform, dataIndex: 'platform', render: (text, record) => renderReferenceCell(text, record)},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({targetObject,targetComponent})=>{

	
	
	const {TargetObjectService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{targetObject.id}</Description> 
<Description term="名称">{targetObject.name}</Description> 
<Description term="经度">{targetObject.longitude}</Description> 
<Description term="纬度">{targetObject.latitude}</Description> 
<Description term="高度">{targetObject.height}</Description> 
<Description term="文本内容">{targetObject.textContent}</Description> 
<Description term="创建时间">{ moment(targetObject.createTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(targetObject,targetComponent)}
      </DescriptionList>
	)

}
	



const TargetObjectBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TargetObjectBase



