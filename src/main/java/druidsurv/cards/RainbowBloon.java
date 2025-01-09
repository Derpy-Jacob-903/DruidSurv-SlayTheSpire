package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import druidsurv.powers.threedelaybloon;
import druidsurv.powers.twodelaybloon;

import static druidsurv.ModFile.makeID;

public class RainbowBloon extends AbstractEasyCard {
    public final static String ID = makeID("RainbowBloon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public RainbowBloon() {
        super(ID, 3, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 80;
        baseBlock = 20;
        tags.add(druidsurv.cards.cardvars.CardTags.BLOON);
        setBackgroundTexture("druidsurvResources/images/512/bloon_attack.png", "druidsurvResources/images/1024/bloon_attack.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction(m, p, (AbstractPower)new threedelaybloon(m, damage), damage, true, AbstractGameAction.AttackEffect.NONE));
        blck();
    }

    @Override
    public void upp()
    {
        upgradeDamage(15);
        upgradeBlock(3);
    }
}