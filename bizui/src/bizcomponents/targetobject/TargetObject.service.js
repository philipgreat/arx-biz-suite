import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}targetObjectManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}targetObjectManager/loadTargetObject/${targetObjectId}/${parametersExpr}/`,
  })
}






const TargetObjectService = { view,
  load }
export default TargetObjectService

