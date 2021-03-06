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

package slatekit.integration.apis

import slatekit.apis.Api
import slatekit.apis.Action
import slatekit.apis.AuthModes
import slatekit.apis.Verbs
import slatekit.common.Context
import slatekit.common.Sources
import slatekit.common.requests.Request
import slatekit.common.info.*

@Api(area = "app", name = "info", desc = "api info about the application and host",
        auth = AuthModes.KEYED, roles = ["admin"], verb = Verbs.AUTO, sources = [Sources.ALL])
class InfoApi(val context: Context)  {

    @Action(desc = "gets info about this build")
    fun build(): Build = context.info.build


    @Action(desc = "get info about the application")
    fun about(): About = context.info.about


    @Action(desc = "get info about the application")
    fun cmd(cmd: Request): About = context.info.about


    @Action(desc = "gets info about the language")
    fun lang(): Lang = context.info.system.lang


    @Action(desc = "gets info about the folders")
    fun dirs(): Folders = context.dirs ?: Folders.none

}
