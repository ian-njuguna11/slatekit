/**
 * <slate_header>
 * url: www.slatekit.com
 * git: www.github.com/code-helix/slatekit
 * org: www.codehelix.co
 * author: Kishore Reddy
 * copyright: 2016 CodeHelix Solutions Inc.
 * license: refer to website and/or github
 * about: A tool-kit, utility library and server-backend
 * mantra: Simplicity above all else
 * </slate_header>
 */

package slatekit.apis.doc

import slatekit.apis.core.*
import slatekit.meta.KTypes


class ApiVisitor(val routes:Routes) {

    /**
     * Displays all the areas in the API container.
     */
    fun visitAreas(visitor: ApiVisit): Unit {
        visitor.onAreasBegin()
        routes.areas.items.forEach { area ->
            visitor.onAreaBegin(area.name)
            visitor.onAreaEnd(area.name)
        }
        visitor.onAreasEnd()
    }


    /**
     * Displays all the APIs in the areas supplied.
     */
    fun visitApis(area: String, visitor: ApiVisit): Unit {
        if (!routes.contains(area)) {
            visitor.onApiError("Area : $area not found")
        }
        else {
            val apis = routes.areas.get(area)?.apis ?: Lookup<Api>(listOf(), { api -> api.name })
            if (apis.size > 0) {
                val maxLength = apis.items.maxBy { it.name.length }?.name?.length ?: 10
                val options = ApiVisitOptions(maxLength, true)

                // 1. Begin the area
                visitor.onApisBegin(area)

                // 2. Sort by name
                val sorted = apis.items.sortedBy { it.name }

                // 3. Now get the api and print info
                sorted.forEach { api -> visitor.onApiBegin(api, options) }
                val lastApiName = sorted.last()
                visitor.onApisEnd(area, "$area.$lastApiName")
            }
        }
    }


    fun visitActions(area:String, name:String, visitor: ApiVisit) {
        if(!routes.contains(area, name)) {
            visitor.onApiError("API not found for $area.$name")
        }
        val api = routes.api(area, name)!!
        val actions = api.actions
        val first: Action? = actions.items.firstOrNull()
        first?.let{ visitor.onApiBeginDetail(api) }
        if (actions.size > 0) {
                visitor.onVisitSeparator()
                val actionNames = actions.items.sortedBy { s -> s.name }
                val maxLength = actionNames.maxBy { it.name.length }?.name?.length ?: 10
                val options = ApiVisitOptions(maxLength)
                actionNames.forEach { action ->
                    val action = actions.get(action.name)
                    action?.let { act ->
                        visitor.onApiActionBegin(action, action.name, options)
                    }
                }
        }
        visitor.onApiActionSyntax(first)
    }


    fun visitAction(action: Action, visitor: ApiVisit, detailMode: Boolean = true, options: ApiVisitOptions?): Unit {
        // action
        visitor.onApiActionBeginDetail(action, action.name, options)

        if (detailMode) {
            visitArgs(action, visitor)
        }
        // args here.
        visitor.onApiActionEnd(action, action.name)
    }


    fun visitArgs(info: Action, visitor: ApiVisit): Unit {
        visitor.onArgsBegin(info)
        if (info.hasArgs) {
            val names = info.paramsUser.map { item -> item.name }.filterNotNull()
            val maxLength = names.maxBy { it.length }?.length ?: 10
            val options = ApiVisitOptions(maxLength)
            info.paramsUser.forEach { argInfo ->

                val clsType = KTypes.getClassFromType(argInfo.type)
                visitor.onArgBegin(argInfo.name!!, "", !argInfo.isOptional, clsType.simpleName!!, options = options)
            }
        }
    }
}
