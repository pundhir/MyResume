package com.colortabz.resume

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * [AboutMeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AboutMeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InterestFragment : Fragment() {
    private var mProfileImageView: ImageView? = null
    private var mSummaryView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_about_me, container, false)
        mProfileImageView = view.findViewById(R.id.profile_image) as ImageView
        mSummaryView = view.findViewById(R.id.profile_summary) as TextView
        return view
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance(): InterestFragment {
            val fragment = InterestFragment()
            return fragment
        }
    }

}// Required empty public constructor
