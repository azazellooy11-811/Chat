package info.fandroid.chat.ui.friends

import android.os.Bundle
import android.view.View
import info.fandroid.chat.R
import info.fandroid.chat.domain.friends.FriendEntity
import info.fandroid.chat.domain.type.None
import info.fandroid.chat.presentation.viewmodel.FriendsViewModel
import info.fandroid.chat.ui.App
import info.fandroid.chat.ui.core.BaseListFragment
import info.fandroid.chat.ui.core.ext.onFailure
import info.fandroid.chat.ui.core.ext.onSuccess

class FriendRequestsFragment : BaseListFragment() {
    override val viewAdapter = FriendRequestsAdapter()

    override val layoutId = R.layout.inner_fragment_list

    lateinit var friendsViewModel: FriendsViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        base {
            friendsViewModel = viewModel {
                onSuccess(friendRequestsData, ::handleFriendRequests)
                onSuccess(approveFriendData, ::handleFriendRequestAction)
                onSuccess(cancelFriendData, ::handleFriendRequestAction)
                onFailure(failureData, ::handleFailure)
            }
        }


        setOnItemClickListener { item, v ->
            (item as? FriendEntity)?.let {
                when (v.id) {
                    R.id.btnApprove -> {
                        showProgress()
                        friendsViewModel.approveFriend(it)
                    }
                    R.id.btnCancel -> {
                        showProgress()
                        friendsViewModel.cancelFriend(it)
                    }
                    else -> {
                        activity?.let { act ->
                            navigator.showUser(act, it)
                        }
                    }
                }
            }
        }

        friendsViewModel.getFriendRequests()
    }


    private fun handleFriendRequests(requests: List<FriendEntity>?) {
        hideProgress()
        if (requests != null && requests.isNotEmpty()) {
            viewAdapter.submitList(requests)
        }
    }

    private fun handleFriendRequestAction(none: None?) {
        hideProgress()
        friendsViewModel.getFriendRequests()
    }
}