package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.cards.cardvars.CardTags;
import druidsurv.powers.onedelaybloon;

import static druidsurv.ModFile.makeID;

public class GreenBloon extends AbstractEasyCard {
    public final static String ID = makeID("GreenBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public GreenBloon() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 25;
        baseBlock = 10;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        tags.add(druidsurv.cards.cardvars.CardTags.BASIC);
        setBackgroundTexture("druidsurvResources/images/512/bloon_attack.png", "druidsurvResources/images/1024/bloon_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new onedelaybloon(m, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        blck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(10);
        upgradeBlock(7);
    }
}