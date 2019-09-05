import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}platformManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}platformManager/loadPlatform/${targetObjectId}/${parametersExpr}/`,
  })
}







const addTargetObject = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addTargetObject/platformId/name/longitude/latitude/height/textContent/imagePath/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTargetObject = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateTargetObjectProperties/platformId/id/name/longitude/latitude/height/textContent/imagePath/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTargetObjectList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeTargetObjectList/platformId/targetObjectIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addViewDevice = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/addViewDevice/platformId/name/longitude/latitude/height/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateViewDevice = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/updateViewDeviceProperties/platformId/id/name/longitude/latitude/height/tokensExpr/`
  const platformId = targetObjectId
  const requestParameters = { ...parameters, platformId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeViewDeviceList = (targetObjectId, parameters) => {
  const url = `${PREFIX}platformManager/removeViewDeviceList/platformId/viewDeviceIds/tokensExpr/`
  const requestParameters = { ...parameters, platformId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const PlatformService = { view,
  load,
  addTargetObject,
  addViewDevice,
  updateTargetObject,
  updateViewDevice,
  removeTargetObjectList,
  removeViewDeviceList }
export default PlatformService

