using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[RequireComponent(typeof(SpriteRenderer))]
[RequireComponent(typeof(EdgeCollider2D))]

public class SpikeCollision : MonoBehaviour
{
    [SerializeField] private Transform spawnPoint;
    public AudioClip deathSound;
    private void OnCollisionEnter2D(Collision2D collision)
    {
        if(collision.gameObject.tag == "Player")
        {
            SoundManager.instance.PlaySingle(deathSound);
            collision.gameObject.transform.position = spawnPoint.position;
        }     
    }
}
