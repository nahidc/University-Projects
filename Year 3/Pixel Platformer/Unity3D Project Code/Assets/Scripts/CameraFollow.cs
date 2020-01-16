using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraFollow : MonoBehaviour
{
    [SerializeField] private float xMax;
    [SerializeField] private float yMax;
    [SerializeField] private float xMin;
    [SerializeField] private float yMin;
    private Transform target;
    private Camera cam;

    void Start()
    {
        target = GameObject.FindGameObjectWithTag("Player").transform;
        cam = Camera.main;
    }

    void LateUpdate()
    {
        transform.position = new Vector3(Mathf.Clamp(target.position.x, xMin, xMax), Mathf.Clamp(target.position.y, yMin, yMax), transform.position.z);
        cam.orthographicSize = 2;


        if(target.position.x > -9.5)
        {
            cam.transform.position = new Vector3(0, 0, -10);
            cam.orthographicSize = 9;
        }
    }
}
