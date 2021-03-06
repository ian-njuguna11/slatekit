/**
<slate_header>
url: www.slatekit.com
git: www.github.com/code-helix/slatekit
org: www.codehelix.co
author: Kishore Reddy
copyright: 2016 CodeHelix Solutions Inc.
license: refer to website and/or github
about: A Kotlin utility library, tool-kit and server backend.
mantra: Simplicity above all else
</slate_header>
 */
package test.apis

import org.junit.Assert
import org.junit.Test
import slatekit.apis.core.Roles

/**
 * Created by kishorereddy on 6/12/17.
 */


class Api_Roles_Tests : ApiTestsBase() {

    @Test
    fun is_authed() {
        Assert.assertEquals(true, Roles(listOf("dev")).isAuthed)
    }


    @Test
    fun is_empty() {
        Assert.assertEquals(true, Roles(listOf()).isEmpty)
    }


    @Test
    fun allow_guest() {
        Assert.assertEquals(true, Roles(listOf(slatekit.common.auth.Roles.GUEST)).allowGuest)
    }


    @Test
    fun allow_all() {
        Assert.assertEquals(false, Roles(listOf(slatekit.common.auth.Roles.ALL)).allowGuest)
    }


    @Test fun can_refer_to_parent() {
        val action = Roles(listOf(slatekit.common.auth.Roles.PARENT))
        val api = Roles(listOf("ops"))
        val roles = action.orElse(api)
        Assert.assertEquals("ops", roles.all.first())
    }
}
